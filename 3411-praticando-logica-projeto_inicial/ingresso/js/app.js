function comprar() {
    const tipoIngresso = document.querySelector('#tipo-ingresso').value; //inferior - superior - pista
    const tiposLista = document.querySelector('.lista');
    const qtd = document.querySelector('#qtd').value;
    const qtdLugarEscolhido = document.querySelector(`#qtd-${tipoIngresso}`);
    var novaQtd = Number(qtdLugarEscolhido.textContent) - qtd;
    qtdLugarEscolhido.textContent != 0 ? qtdLugarEscolhido.innerHTML = novaQtd : Esgotado(qtdLugarEscolhido);
}

function Esgotado(ingresso) {
    ingresso.innerHTML = 0;
    alert(`Ingresso ${ingresso.parentElement.innerText.split(ingresso.innerText)[0]} esta esgotado`);
}
