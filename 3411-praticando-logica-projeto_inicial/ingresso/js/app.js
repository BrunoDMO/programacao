function comprar() {
    const tipoIngresso = document.querySelector('#tipo-ingresso').value; //inferior - superior - pista
    const tiposLista = document.querySelector('.lista');
    const qtd = document.querySelector('#qtd').value;
    const qtdLugarEscolhido = document.querySelector(`#qtd-${tipoIngresso}`);
    var novaQtd = NovaQtd(qtdLugarEscolhido.textContent,qtd);

    qtdLugarEscolhido.textContent <= 0 ? Esgotado(qtdLugarEscolhido) : qtdLugarEscolhido.innerHTML = novaQtd ;
}

function Esgotado(ingresso) {
    ingresso.innerHTML = 0;
    //alert(`Ingresso ${ingresso.parentElement.innerText.split(ingresso.innerText)[0]} esta esgotado`);
}
function NovaQtd(valorIngresso, quantidade){
    if(parseInt(valorIngresso) < quantidade){
        alert(`
        Não foi possível efetuar a compra.
        Você pode estar tentando comprar mais ingressos
        do que estão disponíveis ou
        Os ingressos podem estar esgotados.
        `);
        return valorIngresso;
    } else{
        return parseInt(valorIngresso) - quantidade;
    }
}
