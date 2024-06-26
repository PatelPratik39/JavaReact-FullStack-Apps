// this is Service class which integrates with backedn API for REST API

import axios from "axios";
import { getToken } from "./AuthService";

const URL = "http://localhost:8080/api/todos";

// Add a request interceptor
// axios.interceptors.request.use(
//   function (config) {
//     config.headers["Authorization"] = getToken();
//     return config;
//   },
//   function (error) {
//     // Do something with request error
//     return Promise.reject(error);
//   }
// );

// getAll Todos
export const getAllTodos = () => axios.get(URL);

// addTodo to db
export const saveTodo = (todo) => axios.post(URL, todo);

// GETTodo REST API call
export const getTodo = (id) => axios.get(URL + "/" + id);

// UPDATE TODO
export const updateTodo = (id, todo) => axios.put(URL + "/" + id, todo);

// DELETE REST CLient API call
export const deleteTodo = (id) => axios.delete(URL + "/" + id);

// Patch
export const completedTodo = (id) => axios.patch(URL + "/" + id + "/complete");

// Patch
export const inCompletedTodo = (id) =>
  axios.patch(URL + "/" + id + "/in-complete");
