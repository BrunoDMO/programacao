var valorSubTotal = 0;
//start page with clean cart
document.querySelector('.carrinho__produtos__produto').innerHTML = 
`  
<section class="carrinho__produtos__produto">

</section>
`

function adicionar() {
    //get the values of product's name, quantity and value
    const produtoSelecionado = document.querySelector('#produto');
    const quantidade = document.querySelector('#quantidade').value; //quantity
    const valoresProduto = produtoSelecionado.value.split(" - ");

    const nomeProdutoSelecionado = valoresProduto[0]; //product name
    const valorNumero = valoresProduto[1].split("R$");
    const valorProdutoSelecionado = valorNumero[1]; //product value

    //calc the price and subtotal

    
    valorSubTotal += Number(valorProdutoSelecionado*(quantidade == 0? 1 : quantidade));
    var total = valorSubTotal;

    //add to the shopping cart
    const carrinho = document.querySelector('.carrinho__produtos__produto');
    if (quantidade == 0) {
        
        carrinho.innerHTML += `  <section class="carrinho__produtos__produto">
           <span class="texto-azul">1x</span> ${nomeProdutoSelecionado} <span class="texto-azul">R$${valorProdutoSelecionado}</span>
        </section>`
       
    } else {
        carrinho.innerHTML += `  <section class="carrinho__produtos__produto">
        <span class="texto-azul">${quantidade}x</span> ${nomeProdutoSelecionado} <span class="texto-azul">R$${valorProdutoSelecionado}</span>
     </section>`;
    }

    //update de total value
    const valorTotal = document.querySelector('#valor-total');
    valorTotal.innerHTML = `
    R$${total}
    `   

    //update the quantity to zero
    document.querySelector('#quantidade').value = 1;
}

function limpar() {
    //clean shopping cart
    const carrinho = document.querySelector('.carrinho__produtos__produto');
    carrinho.innerHTML = `  <section class="carrinho__produtos__produto">

     </section>`;

    //clean total and subtotal
    const valorTotal = document.querySelector('#valor-total');
    valorTotal.innerHTML = `
    R$0
    `   
    valorSubTotal = 0;
}