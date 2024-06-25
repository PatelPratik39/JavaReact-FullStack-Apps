import axios from "axios";

const BASE_URL = "http://localhost:8080/api/todos";

export const getAllTodos = () => axios.get(BASE_URL);

export const saveTodo = (todo) => axios.post(BASE_URL, todo);

export const getTodo = (id) => axios.get(BASE_URL + "/" + id);

export const updateTodo = (id, todo) => axios.put(BASE_URL + "/" + id, todo);

export const deleteTodo = (id) => axios.delete(BASE_URL + "/" + id);

export const completeTodo = (id) => axios.patch(BASE_URL+ "/" + id + '/complete');

export const inCompleteTodo = (id) => axios.patch(BASE_URL + "/" + id + "/in-complete");
