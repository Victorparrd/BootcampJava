document.addEventListener('DOMContentLoaded', function () {
    const startBtn = document.getElementById('button');
    const gameBoard = document.getElementById('board');
    const playerXInput = document.getElementById('playerX');
    const playerOInput = document.getElementById('playerO');
  
    let currentPlayer = 'X';
    let board = ['', '', '', '', '', '', '', '', ''];
    let gameOver = false;
  
    // Función para inicializar el juego
    function startGame() {
      const playerX = playerXInput.value.trim();
      const playerO = playerOInput.value.trim();
  
      if (!playerX || !playerO) {
        alert('Por favor, ingresa el nombre de ambos jugadores.');
        return;
      }
  
      // Reiniciar el tablero
      board = ['', '', '', '', '', '', '', '', ''];
      gameOver = false;
  
      // Limpiar el tablero
      gameBoard.innerHTML = '';
  
      // Crear el tablero
      for (let i = 0; i < 9; i++) {
        const cell = document.createElement('div');
        cell.classList.add('cell');
        cell.dataset.index = i;
        cell.addEventListener('click', handleCellClick);
        gameBoard.appendChild(cell);
      }
    }
  
    // Función para manejar el click en una celda
    function handleCellClick(event) {
      const index = event.target.dataset.index;
  
      if (board[index] || gameOver) return;
  
      board[index] = currentPlayer;
      event.target.textContent = currentPlayer;
  
      if (checkWinner()) {
        alert(`¡El jugador ${currentPlayer} ha ganado!`);
        gameOver = true;
        return;
      }
  
      if (checkDraw()) {
        alert('¡Empate!');
        gameOver = true;
        return;
      }
  
      currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
    }
  
    // Función para verificar si hay un ganador
    function checkWinner() {
      const winningCombinations = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // filas
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // columnas
        [0, 4, 8], [2, 4, 6]              // diagonales
      ];
  
      return winningCombinations.some(combination => {
        const [a, b, c] = combination;
        return board[a] && board[a] === board[b] && board[a] === board[c];
      });
    }
  
    // Función para verificar si hay un empate
    function checkDraw() {
      return board.every(cell => cell !== '');
    }
  
    // Event listener para el botón de comenzar juego
    startBtn.addEventListener('click', startGame);
  });
  