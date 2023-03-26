class Product{

    constructor(name, id, price) {
        this.name = name
        this.id = id
        this.price = price
    }

    toHtmlElement(){
        const divProduct = document.createElement("div")
        const name = document.createElement("div")
        name.innerHTML= `${this.name}, ${this.price} euros`
        const deleteBtn = document.createElement("button")
        deleteBtn.innerHTML = "delete"
        deleteBtn.addEventListener("click", (e)=>{
            deleteBtn.parentNode.remove()
            products.pop()
            savePanier()

            if (products.length === 0){
                const buyBtn = document.getElementById("buyBtn")
                buyBtn.style.display = "none"
            }
        })


        divProduct.appendChild(name)
        divProduct.appendChild(deleteBtn)
        return divProduct
    }

    toCommandeHtmlElement(){
        const divProduct = document.createElement("div")
        const name = document.createElement("div")
        name.innerHTML= `${this.name}`
        divProduct.appendChild(name)
        return divProduct
    }
}

function savePanier(){
    localStorage.setItem("panier", JSON.stringify(products))
}

function ajoutPanier(name, id, price){
    const product = new Product(name, id, price)
    const divProduct = product.toHtmlElement()

    const panierContainer = document.getElementById("panierContainer")
    panierContainer.appendChild(divProduct)

    products.push(product)
    savePanier()

    if (!buyButton){
        addBuyBtn()
    }
}

function addBuyBtn(){
    buyButton = false
    const buyBtn = document.getElementById("buyBtn")
    buyBtn.style.display = "block"
}

function getPanier(){
    const str = localStorage.getItem("panier")
    for (const elt of JSON.parse(str)) {
        products.push(new Product(elt.name, elt.id, elt.price))
    }
}

function loadPanier(){
    getPanier()
    for (const product of products) {
        const divProduct = product.toHtmlElement()
        const panierContainer = document.getElementById("panierContainer")
        panierContainer.appendChild(divProduct)
    }
    if (products.length){
        addBuyBtn()
    }
}

function getPrice(){
    let prix = 0
    for (const product of products){
        prix += product.price
    }
    return prix
}
