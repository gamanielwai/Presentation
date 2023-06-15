import axios from 'axios';

// Definiera URL:en
const API_URL = 'http://192.168.99.100:8080/api/v1/todos';

class Api {
  // Hämta alla todos från
  getAllTodos() {
    return axios.get(API_URL, { headers: { 'Content-Type': 'application/json' } });
  }

  // Skapa en ny todo genom att skicka en POST-begäran till API:et
  createTodo(todo) {
    return axios.post(API_URL, todo, { headers: { 'Content-Type': 'application/json' } });
  }

  // Hämta en specifik todo baserat på dess id
  getTodoById(todoId) {
    return axios.get(API_URL + '/' + todoId);
  }

  // Uppdatera en specifik todo baserat på dess id
  updateTodo(todoId, todo) {
    return axios.put(API_URL + '/' + todoId, todo);
  }

  // Radera en specifik todo baserat på dess id
  deleteTodo(todoId) {
    return axios.delete(API_URL + '/' + todoId);
  }
}

// Exportera en instans av Api-klassen så att den kan användas i andra delar av applikationen
export default new Api();