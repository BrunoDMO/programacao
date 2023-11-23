// let titulo = document.querySelector('h1');
// titulo.innerHTML = 'Jogo do número Secreto';

// let paragrafo = document.querySelector('p');
// paragrafo.innerHTML = 'Escolha um número entre 1 e 10';

let numeroSecreto = gerarNumeroAleatorio();

escreveTextoNaTela('h1', 'Jogo do número Secreto');
escreveTextoNaTela('p', 'Escolha um número entre 1 e 10');


const botaoChute = document.querySelector('[botaoChute]');
botaoChute.addEventListener('click', () => {
    verificarChute();
})

const botaoNovoJogo = document.querySelector('#reiniciar');
botaoNovoJogo.addEventListener('click', () => {
    location.href = location.href;
})

function escreveTextoNaTela(tag, texto) {
    let paragrafo = document.querySelector(tag);
    paragrafo.innerHTML = texto;
}

function verificarChute() {
    const chute = document.querySelector("input[type='number']").value;
    if (chute == numeroSecreto) {
        escreveTextoNaTela('p', 'Acertou!');
        botaoNovoJogo.removeAttribute('disabled');
    }
    else {
        if (chute > numeroSecreto) {
            escreveTextoNaTela('p', 'Numero secreto é menor');
        } else {
            escreveTextoNaTela('p', 'Numero secreto é maior');
        }
    }

}

function gerarNumeroAleatorio() {
    let numero = parseInt(Math.random() * 10 + 1);
    console.log(`o numero secreto é ${numero}`);
    return numero;
}

// function mostrarTabuada(numero) {
//     for (let i = 1; i <= 10; i++) {
//       let resultado = numero * i;
//       console.log(`${numero} x ${i} = ${resultado}`);
//     }
//   }
  
//   // Exemplo de uso
//   let numero = 3;
//   mostrarTabuada(numero);

// console.log(`maior valor entre 2,3,5 é : ${retornaMaior([2,3,5])}`)
// function retornaMaior(vetor) {
//     return Math.max(...vetor);
// }