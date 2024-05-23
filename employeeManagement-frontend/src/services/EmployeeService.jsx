import axios from "axios";

const BASE_URL = "http://localhost:8080/api/employees";

// All Employee REST API call
export const listEmployees = () => {
  return axios.get(BASE_URL);
};

// Create Employee REST API call
export const createEmployee = (employee) => {
  return axios.post(BASE_URL, employee);
};

// Get Employee using ID REST API call
export const getEmployee = (employeeId) => {
  return axios.get(BASE_URL, +"/" + employeeId);
};

// Update EMployee based on ID
export const updateEmployee = (employeeId, employee) => {
  return axios.put(BASE_URL + "/" + employeeId, employee);
};

// Delete Employee basd on Id
export const deleteEmployee = (employeeId) => {
  return axios.delete(BASE_URL, +"/" + employeeId);
};
