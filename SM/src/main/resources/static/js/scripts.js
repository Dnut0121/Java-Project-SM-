document.addEventListener("DOMContentLoaded", function() {
    const brandImages = {
        nike: ["images/nike/shoe1.png", "images/nike/shoe2.png", "images/nike/shoe3.png"],
        adidas: ["images/adidas/shoe1.png", "images/adidas/shoe2.png", "images/adidas/shoe3.png"],
        converse: ["images/converse/shoe1.png", "images/converse/shoe2.png", "images/converse/shoe3.png"],
        nb: ["images/nb/shoe1.png", "images/nb/shoe2.png", "images/nb/shoe3.png"]
    };

    Object.keys(brandImages).forEach(brand => {
        let currentIndex = 0;
        const shoeImageElement = document.querySelector(`.${brand}-box .shoe-image`);
        setInterval(() => {
            shoeImageElement.classList.remove('slide-in');
            shoeImageElement.classList.add('slide-out');
            setTimeout(() => {
                currentIndex = (currentIndex + 1) % brandImages[brand].length;
                shoeImageElement.src = brandImages[brand][currentIndex];
                shoeImageElement.classList.remove('slide-out');
                shoeImageElement.classList.add('slide-in');
            }, 500); // Match the transition duration in CSS
        }, 2000);
    });
});
