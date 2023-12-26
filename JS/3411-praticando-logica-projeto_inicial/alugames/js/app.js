function alterarStatus(idGame) {
    const game = document.querySelector(`#game-${idGame}`); // get the game selected
    const gameImage = game.querySelector('.dashboard__item__img');
    const situacao = game.querySelector('.dashboard__item__button');

    //check the state of the game and change
    if (situacao.innerHTML == 'Alugar') {
        situacao.innerHTML = 'Devolver';
        situacao.classList.add('dashboard__item__button--return');
        gameImage.classList.add('dashboard__item__img--rented');
    } else {
        situacao.innerHTML = 'Alugar';
        situacao.classList.remove('dashboard__item__button--return');
        gameImage.classList.remove('dashboard__item__img--rented');
    }
}