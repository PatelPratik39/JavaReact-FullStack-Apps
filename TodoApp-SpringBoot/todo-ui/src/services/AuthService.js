import axios from "axios";

const AUTH_URL = "http://localhost:8080/api/auth";

export const registerAPICall = (registerobj) =>
  axios.post(AUTH_URL + "/register", registerobj);

export const loginAPICall = (usernameOrEmail, password) =>
  axios.post(AUTH_URL + "/login", { usernameOrEmail, password });

export const storeToken = (token) => localStorage.setItem("token", token);

export const getToken = () => localStorage.getItem("token");
