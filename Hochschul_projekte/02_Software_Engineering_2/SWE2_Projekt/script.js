let openShopping = document.querySelector('.shopping');
let closeShopping = document.querySelector('.closeShopping');
let list = document.querySelector('.list');
let listCard = document.querySelector('.listCard');
let body = document.querySelector('body');
let total = document.querySelector('.total');
let quantity = document.querySelector('.quantity');

openShopping.addEventListener('click', function() {
    body.classList.add('active');
});
closeShopping.addEventListener('click', function() {
    body.classList.remove('active');
});

let products = [
    {
        id: 1,
        name: 'DAX pomade super light',
        image: 'DAX pomade super light.png',
        price: 19.99
    },
    {
        id: 2,
        name: 'dimes sour apple',
        image: 'dimes sour apple.png',
        price: 24.99
    },
    {
        id: 3,
        name: 'dimes mango',
        image: 'dimes mango.png',
        price: 14.99
    },
    {
        id: 4,
        name: 'Fitne herbal tee',
        image: 'Fitne herbal tee.png',
        price: 14.99
    },
    {
        id: 5,
        name: 'Capri-sun',
        image: 'Capri-sun.png',
        price: 14.99
    },
    {
        id: 6,
        name: 'chio tortillas hot chili',
        image: 'chio tortillas hot chili.png',
        price: 14.99
    },
    {
        id: 7,
        name: 'foco coconut juice',
        image: 'foco coconut juice.png',
        price: 14.99
    },
    {
        id: 8,
        name: 'comb thru extra streng',
        image: 'comb thru extra streng.png',
        price: 14.99
    },
    {
        id: 9,
        name: 'chupa chups fraise',
        image: 'chupa chups fraise.png',
        price: 14.99
    }

];

let listCards = [];

function initApp() {
    for (var i = 0; i < products.length; i++) {
        var value = products[i];
        var newDiv = document.createElement('div');
        newDiv.classList.add('item');
        newDiv.innerHTML = `
            <img src="img/${value.image}">
            <div class="title">${value.name}</div>
            <div class="price">${value.price.toLocaleString()}</div>
            <button onclick="addToCard(${i})">In den Warenkorb</button>`;
        list.appendChild(newDiv);
    }
}
initApp();

function addToCard(key) {
    if (listCards[key] == null) {
        listCards[key] = {
            id: products[key].id,
            name: products[key].name,
            image: products[key].image,
            price: products[key].price,
            quantity: 1
        };
    }
    reloadCard();
}

function reloadCard() {
    listCard.innerHTML = '';
    var count = 0;
    var totalPrice = 0;
    for (var i = 0; i < listCards.length; i++) {
        var value = listCards[i];
        if (value != null) {
            totalPrice += value.price * value.quantity;
            count += value.quantity;

            var newDiv = document.createElement('li');
            newDiv.innerHTML = `
                <div><img src="img/${value.image}"/></div>
                <div>${value.name}</div>
                <div>${value.price.toLocaleString()}</div>
                <div>
                    <button onclick="changeQuantity(${i}, ${value.quantity - 1})">-</button>
                    <div class="count">${value.quantity}</div>
                    <button onclick="changeQuantity(${i}, ${value.quantity + 1})">+</button>
                </div>`;
            listCard.appendChild(newDiv);
        }
    }
    total.innerText = totalPrice.toLocaleString();
    quantity.innerText = count;
}

function changeQuantity(key, newQuantity) {
    if (newQuantity == 0) {
        listCards[key] = null;
    } else {
        listCards[key].quantity = newQuantity;

    }
    reloadCard();
}
