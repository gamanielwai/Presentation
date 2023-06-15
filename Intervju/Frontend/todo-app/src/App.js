// Importera React och CSS-filen
import React from 'react';
import './App.css';

// Importera TodoList-komponenten
import TodoList from './components/TodoList';

// Huvudkomponenten i din app
function App() {
  // Returnera TodoList-komponenten innesluten i en div med klassen "App"
  return (
    <div className="App">
      <TodoList />
    </div>
  );
}

// Exportera App-komponenten så att den kan användas i andra delar av applikationen
export default App;