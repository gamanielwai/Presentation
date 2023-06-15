import React, { Component } from 'react';
import Api from '../api';

class TodoList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      todos: [],
      newTodoTitle: '',
      newTodoDescription: '',
      editingId: null,
      editingTitle: '',
      editingDescription: ''
    };
  }

  // Funktion för att markera en Todo som slutförd eller ej slutförd
  handleCompleteTodo = async (todo) => {
    todo.completed = !todo.completed;
    const response = await Api.updateTodo(todo.id, todo);
    const updatedTodo = response.data;
    const todos = this.state.todos.map(t => t.id === todo.id ? updatedTodo : t);
    this.setState({ todos });
  }

  // Funktion för att lägga till en ny Todo
  handleAddTodo = async () => {
    const newTodo = {
      title: this.state.newTodoTitle,
      description: this.state.newTodoDescription,
      completed: false
    };
    const response = await Api.createTodo(newTodo);
    const todo = response.data;
    this.setState({
      todos: [...this.state.todos, todo],
      newTodoTitle: '',
      newTodoDescription: ''
    });
  }

  // Funktion för att uppdatera en befintlig Todo
  handleUpdateTodo = async (todo) => {
    if (this.state.editingId === todo.id) {
      todo.title = this.state.editingTitle;
      todo.description = this.state.editingDescription;
      const response = await Api.updateTodo(todo.id, todo);
      const updatedTodo = response.data;
      const todos = this.state.todos.map(t => t.id === todo.id ? updatedTodo : t);
      this.setState({ todos, editingId: null });
    } else {
      this.setState({ editingId: todo.id, editingTitle: todo.title, editingDescription: todo.description });
    }
  }

  // Funktion för att radera en befintlig Todo
  handleDeleteTodo = async (id) => {
    await Api.deleteTodo(id);
    const todos = this.state.todos.filter(t => t.id !== id);
    this.setState({ todos });
  }

  // Funktion för att hämta alla Todos när komponenten har monterats
  componentDidMount() {
    Api.getAllTodos().then(response => {
      this.setState({ todos: response.data });
    });
  }

  render() {
    return (
      <div className="container mt-4">
        <h1 className="mb-4">Todo List</h1>
        <div className="mb-4">
          <input
            value={this.state.newTodoTitle}
            onChange={e => this.setState({ newTodoTitle: e.target.value })}
            placeholder="Ny Todo-titel"
            className="form-control mb-2"
          />
          <input
            value={this.state.newTodoDescription}
            onChange={e => this.setState({ newTodoDescription: e.target.value })}
            placeholder="Ny Todo-beskrivning"
            className="form-control mb-2"
          />
          <button onClick={this.handleAddTodo} className="btn btn-primary">Lägg till Todo</button>
        </div>

        <ul className="list-group">
          {this.state.todos.map(todo =>
            <li key={todo.id} className="list-group-item">
              <div className="d-flex align-items-center">
                <input
                  type="checkbox"
                  checked={todo.completed}
                  onChange={() => this.handleCompleteTodo(todo)}
                  className="mr-2"
                />
                {this.state.editingId === todo.id ? (
                  <>
                    <input
                      value={this.state.editingTitle}
                      onChange={e => this.setState({ editingTitle: e.target.value })}
                      className="form-control mb-2 mr-sm-2"
                    />
                    <input
                      value={this.state.editingDescription}
                      onChange={e => this.setState({ editingDescription: e.target.value })}
                      className="form-control mb-2 mr-sm-2"
                    />
                  </>
                ) : (
                  <>
                    <div className="flex-grow-1" style={{ textDecoration: todo.completed ? 'line-through' : 'none', color: todo.completed ? 'gray' : 'black' }}>
                      <strong>{todo.title}</strong>
                      <br />
                      {todo.description}
                    </div>
                  </>
                )}
                <button onClick={() => this.handleUpdateTodo(todo)} className="btn btn-success btn-sm ml-2">
                  {this.state.editingId === todo.id ? 'Spara' : 'Redigera'}
                </button>
                <button onClick={() => this.handleDeleteTodo(todo.id)} className="btn btn-danger btn-sm ml-2">Radera</button>
              </div>
            </li>
          )}
        </ul>
      </div>
    );
  }
}

export default TodoList;