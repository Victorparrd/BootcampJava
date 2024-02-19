document.getElementById('verificarBtn').addEventListener('click', function() {
    var tipoDoc = document.getElementById('inputTipoDoc').value;
    var inputNumeroDoc = document.getElementById('inputNumeroDoc').value;
    var regexRuc = /^\d{6}-\d{1}$/;
    var regexSoloNumeros = /^[0-9]+$/;

    if ((tipoDoc === '1' && regexRuc.test(inputNumeroDoc)) || (tipoDoc === '2' && regexSoloNumeros.test(inputNumeroDoc))) {
        alert('El documento es válido.');
    } else {
        if (tipoDoc === '1') {
            alert('El RUC no cumple con el formato requerido (999999-9).');
        } else if (tipoDoc === '2') {
            alert('El número de documento no cumple con el formato requerido.');
        }
    }
});
