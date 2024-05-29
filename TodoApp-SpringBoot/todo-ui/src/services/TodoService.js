// this is Service class which integrates with backedn API for REST API

import axios from "axios";
const URL = "http://localhost:8080/api/todos";

// getAll TOdos
export const getAllTodos = () => axios.get(URL);

// addTodo to db
export const saveTodo = (todo) => axios.post(URL, todo);
