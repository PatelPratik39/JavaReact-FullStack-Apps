import React, { useEffect, useRef, useState } from "react";
import { getContacts, saveContact } from "./api/contactServie.js";
import Header from "./components/Header";
import { Routes, Route, Navigate } from "react-router-dom";
import ContactList from "./components/ContactList";
import ContactDetails from "./components/ContactDetails";
import "react-toastify/dist/ReactToastify.css";
import { toastError } from "./api/ToastService";
import { ToastContainer } from "react-toastify";

function App() {
  const modalRef = useRef();
  const fileRef = useRef();
  const [data, setData] = useState({});
  const [currentPage, setCurrentPage] = useState(0);
  const [file, setFile] = useState(undefined);
  const [values, setValues] = useState({
    name: "",
    email: "",
    phone: "",
    address: "",
    title: "",
    status: ""
  });

  const getAllContacts = async (page = 0, size = 10) => {
    try {
      setCurrentPage(page);
      const response = await getContacts(page, size);
      setData(response.data);
      console.log(response.data);
    } catch (error) {
      console.error(error);
      fileRef.current.value = null;
    }
  };

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const handleNewContact = async (event) => {
    event.preventDefault();
    try {
      const response = await saveContact(values);
      const formData = new FormData();
      formData.append("file", file, file.name);
      formData.append("id", response.data.id);
      const photoResponse = await updatePhoto(formData);
      toggleModal(false);
      setFile(undefined);
      fileRef.current.value = null;
      setValues({
        name: "",
        email: "",
        phone: "",
        address: "",
        title: "",
        status: ""
      });
      getAllContacts();
    } catch (error) {
      console.error(error);
      toastError(error.message);
    }
  };

  const updateContact = async (contact) => {
    try {
      const response = await saveContact(contact);
      console.log(response.data);
    } catch (error) {
      console.error(error);
      toastError(error.message);
    }
  };

  const updateImage = async (formData) => {
    try {
      const photoResponse = await updatePhoto(formData);
      console.log(photoResponse.data);
    } catch (error) {
      console.error(error);
      toastError(error.message);
    }
  };

  const toggleModal = (show) =>
    show ? modalRef.current.showModal() : modalRef.current.close();

  useEffect(() => {
    getAllContacts();
  }, []);

  return (
    <>
      <Header toggleModal={toggleModal} nbOfContacts={data.totalElements} />
      <main className="main">
        <div className="container">
          <Routes>
            <Route path="/" element={<Navigate to={"/contacts"} />} />
            <Route
              path="/contacts"
              element={
                <ContactList
                  data={data}
                  currentPage={currentPage}
                  getAllContacts={getAllContacts}
                />
              }
            />
            <Route
              path="/contacts/:id"
              element={
                <ContactDetails
                  updateContact={updateContact}
                  updateImage={updateImage}
                />
              }
            />
          </Routes>
        </div>
      </main>
      {/* Modal */}
      <dialog ref={modalRef} className="modal" id="modal">
        <div className="modal__header">
          <h3>New Contact</h3>
          <i onClick={() => toggleModal(false)} className="bi bi-x-lg"></i>
        </div>
        <div className="divider"></div>
        <div className="modal__body">
          <form onSubmit={handleNewContact}>
            <div className="user-details">
              <div className="input-box">
                <span className="details">Name</span>
                <input
                  type="text"
                  value={values.name}
                  onChange={onChange}
                  name="name"
                  required
                />
              </div>
              <div className="input-box">
                <span className="details">Email</span>
                <input
                  type="text"
                  value={values.email}
                  onChange={onChange}
                  name="email"
                  required
                />
              </div>
              <div className="input-box">
                <span className="details">Title</span>
                <input
                  type="text"
                  value={values.title}
                  onChange={onChange}
                  name="title"
                  required
                />
              </div>
              <div className="input-box">
                <span className="details">Phone Number</span>
                <input
                  type="text"
                  value={values.phone}
                  onChange={onChange}
                  name="phone"
                  required
                />
              </div>
              <div className="input-box">
                <span className="details">Address</span>
                <input
                  type="text"
                  value={values.address}
                  onChange={onChange}
                  name="address"
                  required
                />
              </div>
              <div className="input-box">
                <span className="details">Account Status</span>
                <input
                  type="text"
                  value={values.status}
                  onChange={onChange}
                  name="status"
                  required
                />
              </div>
              <div className="file-input">
                <span className="details">Profile Photo</span>
                <input
                  type="file"
                  onChange={(event) => setFile(event.target.files[0])}
                  ref={fileRef}
                  name="photo"
                  required
                />
              </div>
            </div>
            <div className="form_footer">
              <button
                onClick={() => toggleModal(false)}
                type="button"
                className="btn btn-danger"
              >
                Cancel
              </button>
              <button type="submit" className="btn">
                Save
              </button>
            </div>
          </form>
        </div>
      </dialog>
      <ToastContainer />
    </>
  );
}

export default App;
