import axios from "axios";

const AUTH_BASE_URL = "http://localhost:8080/api/auth";

export const registerAPICall = (registerObj) =>
  axios.post(AUTH_BASE_URL + "/register", registerObj);

export const loginAPICall = (loginObj) =>
  axios.post(AUTH_BASE_URL + "/login", loginObj);
