let amigos = [];
function adicionar() {
    let listaAmigosIncluidos = document.getElementById('lista-amigos');
    let nomeAmigo = document.getElementById('nome-amigo');
    if (nomeAmigo.value != '') {
        amigos.push(nomeAmigo.value);
        amigos.length <= 1 ? listaAmigosIncluidos.textContent += nomeAmigo.value : listaAmigosIncluidos.textContent += ', ' + nomeAmigo.value;
        nomeAmigo.value = ''; //clean the input
    }
}

function sortear() {
    const pares = [];
    const listaSorteio = document.getElementById('lista-sorteio');
    if (listaSorteio.innerHTML == '') {
        embaralha(amigos);
        for (let index = 0; index < amigos.length; index++) {
            index == amigos.length - 1 ?
                listaSorteio.innerHTML += ` ${amigos[index]} --> ${amigos[0]} <br>` :
                listaSorteio.innerHTML += ` ${amigos[index]} --> ${amigos[index + 1]} <br>`;
        }
    }
}

function reiniciar() {
    document.getElementById('lista-sorteio').innerHTML = '';
    document.getElementById('lista-amigos').innerHTML = '';
    amigos = [];
}

function embaralha(lista) {

    for (let indice = lista.length; indice; indice--) {

        const indiceAleatorio = Math.floor(Math.random() * indice);

        // guarda de um índice aleatório da lista
        const elemento = lista[indice - 1];

        lista[indice - 1] = lista[indiceAleatorio];

        lista[indiceAleatorio] = elemento;
    }
}