function generarNumero() {
    var numeroAleatorio = Math.floor(Math.random() * 6) + 1;
    document.getElementById('numero').textContent = numeroAleatorio;
}