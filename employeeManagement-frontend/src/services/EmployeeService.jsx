import axios from "axios";

const BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = () => {
  return axios.get(BASE_URL);
};

export const createEmployee = (employee) => {
  return axios.post(BASE_URL, employee)
}