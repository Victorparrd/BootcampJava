let currentInput = '';

function appendNumber(num) {
  if (currentInput === '0') {
    currentInput = '';
  }
  currentInput += num;
  document.getElementById('result').textContent = currentInput;
}

function appendOperator(op) {
  if (currentInput !== '' && !isNaN(currentInput[currentInput.length - 1])) {
    currentInput += op;
    document.getElementById('result').textContent = currentInput;
  }
}

function appendDecimal(decimal) {
  if (!currentInput.includes(decimal)) {
    currentInput += decimal;
    document.getElementById('result').textContent = currentInput;
  }
}

function clearResult() {
  currentInput = '0';
  document.getElementById('result').textContent = currentInput;
}

function calculate() {
  try {
    const result = eval(currentInput);
    document.getElementById('result').textContent = result;
    currentInput = result.toString();
  } catch (error) {
    document.getElementById('result').textContent = 'Error';
    currentInput = '';
  }
}