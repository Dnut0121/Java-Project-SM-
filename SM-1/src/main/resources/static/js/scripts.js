document.addEventListener("DOMContentLoaded", function() {
    const brandImages = {
        nike: ["images/nike/shoe1.png", "images/nike/shoe2.png", "images/nike/shoe3.png"],
        adidas: ["images/adidas/shoe1.png", "images/adidas/shoe2.png", "images/adidas/shoe3.png"],
        converse: ["images/converse/shoe1.png", "images/converse/shoe2.png", "images/converse/shoe3.png"],
        nb: ["images/nb/shoe1.png", "images/nb/shoe2.png", "images/nb/shoe3.png"]
    };

    Object.keys(brandImages).forEach(brand => {
        const shoeImageElement = document.querySelector(`.${brand}-box .shoe-image`);
        if (shoeImageElement) {
            let currentIndex = 0;
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
        }
    });

    const loginButton = document.getElementById("login-button");
    const backButton = document.getElementById("back-button");
    const homeButton = document.getElementById("home-button");
    const leftBox = document.getElementById("left-box");
    const rightBox = document.querySelector(".right-box");
    const loginForm = document.getElementById("login-form");
    const signupForm = document.getElementById("signup-form");
    const signupButton = document.getElementById("signup-button");
    const cancelSignupButton = document.getElementById("cancel-signup-button");
    const container = document.querySelector('.container');

    if (loginButton && backButton && homeButton && leftBox && rightBox && loginForm && signupForm && signupButton && cancelSignupButton) {
        loginButton.addEventListener("click", function() {
            leftBox.classList.add("expanded");
            rightBox.classList.add("collapsed");
            loginButton.style.display = "none";
            backButton.style.display = "block";
            setTimeout(() => {
                loginForm.style.display = "flex";
            }, 500); // Match the transition duration in CSS
        });

        backButton.addEventListener("click", function() {
            leftBox.classList.remove("expanded");
            rightBox.classList.remove("collapsed");
            loginButton.style.display = "block";
            backButton.style.display = "none";
            loginForm.style.display = "none";
            signupForm.style.display = "none";
        });

        homeButton.addEventListener("click", function(event) {
            event.preventDefault();
            container.classList.add('slide-out-left');
            setTimeout(() => {
                window.location.href = homeButton.getAttribute('href');
            }, 500); // Match the transition duration in CSS
        });

        signupButton.addEventListener("click", function() {
            loginForm.style.display = "none";
            signupForm.style.display = "flex";
        });

        cancelSignupButton.addEventListener("click", function() {
            signupForm.style.display = "none";
            loginForm.style.display = "flex";
        });

        // 페이지 로드 시 애니메이션 추가
        document.querySelectorAll('.rounded-box a').forEach(link => {
            link.addEventListener('click', function(event) {
                event.preventDefault();
                container.classList.add('slide-out-right');
                setTimeout(() => {
                    container.classList.remove('slide-out-right');
                    container.classList.add('slide-in-right');
                    window.location.href = link.getAttribute('href');
                }, 500); // Match the transition duration in CSS
            });
        });
    }
});
