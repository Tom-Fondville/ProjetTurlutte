const nomClientInput = document.getElementById("nomClient");
const prenomClientInput = document.getElementById("prenomClient");
const adresseLivraisonInput = document.getElementById("AdresseLivraison");
const adresseCommandeInput = document.getElementById("AdresseCommande");
let products = []
getPanier()
const prix = getPrice()
for (const product of products) {
    const divProduct = product.toCommandeHtmlElement()
    const panierContainer = document.getElementById("panierContainer")
    panierContainer.appendChild(divProduct)
}
const prixContainer = document.getElementById("prix")
prixContainer.innerHTML = `Le prix total de votre commande est de ${prix} euros`

const validaterBtn = document.getElementById("validerCommande")
validaterBtn.addEventListener(("click"),(e) => {
    const nomClient = nomClientInput.value
    const prenomClient = prenomClientInput.value
    const adresseLivraison = adresseLivraisonInput.value
    const adresseCommande = adresseCommandeInput.value

    if (nomClient === '' || prenomClient === '' || adresseCommande === '' || adresseLivraison === '')
        return;


    const body = {
        nomClient : nomClient,
        "prenomClient" : prenomClient,
        "adresseLivraison" : adresseLivraison,
        "adresseCommande" : adresseCommande,
        "prix" : prix,
        "products" : products
    }
    fetch("http://localhost:8080/commande/save",
        {
            method :"POST",
            body: JSON.stringify(body),
            headers: {
                "Content-Type": "application/json",
            },
        }
    );

    const endActionContainer = document.getElementById("endActionContainer")
    endActionContainer.innerHTML = ""
    const validateText = document.createElement("a")
    validateText.innerHTML = "Commande validée"
    validateText.style.color = "green"
    validateText.href = "/"
    endActionContainer.appendChild(validateText)

    nomClientInput.disabled="disabled"
    prenomClientInput.disabled="disabled"
    adresseCommandeInput.disabled="disabled"
    adresseLivraisonInput.disabled="disabled"

    products = []
    savePanier()
})