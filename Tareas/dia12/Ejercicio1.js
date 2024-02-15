// 1. Escribir una función en JavaScript que calcule la versión que suma en la ecuación cuadrática
var a = 2;
var b = 9;
var c = 4;

function cuadraticaPositiva(a, b, c) {
    var r = ((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a);
    return r;
}

console.log("Cuadratica (+): ", cuadraticaPositiva(a, b, c));

// 2. Escribir una función en JavaScript que calcule la versión que resta en la ecuación cuadrática
function cuadraticaNegativa(a, b, c) {
    var r = ((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a);
    return r;
}

console.log("Cuadratica (-): ", cuadraticaNegativa(a, b, c));

/* 3. Escribir una función en JavaScript que reciba un id y un string 
y ponga como innerHTML del elemento con el id referenciado el valor del string
Entrada: id, string Salida: n/a
*/
function setInnerHTML(id, string) {
    let elemento = document.getElementById(id);
    elemento.innerHTML = string;
}
setInnerHTML("titulo", "Probando Javascript");
/*
4. Escribir una función en JavaScript que reciba un id, y ponga en el innerHTML del
elemento con el id referenciado un número aleatorio entre 1 y 100
*/
function innerHTML(id) {
    let elemento = document.getElementById(id);
    elemento.innerHTML = Math.floor(Math.random() * 100) + 1;

}
innerHTML("parrafo");