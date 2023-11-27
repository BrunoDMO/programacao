function alterarStatus(idGame) {
    const game = document.querySelector(`#game-${idGame}`); // get the game selected
    const situacao = game.lastElementChild; 

    //check the state of the game and change
    if (situacao.innerHTML == 'Alugar') {
        situacao.innerHTML = 'Devolver';
        situacao.setAttribute('class', 'dashboard__item__button dashboard__item__button--return' );
    } else {
        situacao.innerHTML = 'Alugar';
        situacao.setAttribute('Class', 'dashboard__item__button');
    }
}