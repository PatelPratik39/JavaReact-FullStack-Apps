// Write REST Client code to make a REST API call using axios API

import axios from "axios";
const BASE_URL = "http://localhost:8080/api/departments";

// getALlDepartments from backend Database
export const getAllDepartments = () => axios.get(BASE_URL);

// Add Department  using REST API from Backend
export const createDepartment = (department) =>
  axios.post(BASE_URL, department);

// Add Department using ID using REST API from Backend
export const getDepartmentById = (departmentId) =>
  axios.get(BASE_URL + "/" + departmentId);

// Update Department using ID using REST API from Backend
export const updateDepartment = (departmentId, department) =>
  axios.put(BASE_URL + "/" + departmentId, department);

// DELETE Department using ID
export const deleteDepartment = (departmentId) =>
  axios.delete(BASE_URL + "/" + departmentId);
