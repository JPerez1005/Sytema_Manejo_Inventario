AOS.init();

// Animación con GSAP para cerrar las paredes
gsap.to('.left-wall', {
    width: '50vw',
    duration: 1,
    scrollTrigger: {
        trigger: '.container',
        start: '0%',
        end: '70%',
        scrub: true
    }
});

gsap.to('.right-wall', {
    width: '50vw',
    duration: 1,
    scrollTrigger: {
        trigger: '.container',
        start: '0%',
        end: '70%',
        scrub: true
    }
});

// Animación con GSAP para el texto que se desplaza horizontalmente
gsap.to('.title-fixed2', {
    visibility: 'visible',
    x: '70%',
    duration: 10,
    scrollTrigger: {
        trigger: '.container',
        start: '65%',
        end: '100%', // Termina cuando el contenedor llega al fondo
        scrub: true
    }
});

//animacion main
let tl = gsap.timeline({
    scrollTrigger: {
        trigger: "#main",
        markers: false,
        start: "50% 50%",
        end: "100% 50%",
        scrub: 0.8,
        pin: true
    }
});

tl
    .to("#top", {
        top: "-60%",
        // opacity: 0
    }, 'a')

    .to("#bottom", {
        bottom: "-60%",
        // opacity: 0
    }, 'a')

// .to("#bottom-h",{
//     bottom:"-200%"
// },'a')

// .to("#top-h",{
//     bottom:"-10%"
// },'a')

// gsap.to('#top', {
//     visibility: 'visible',
//     duration: 1,
//     scrollTrigger: {
//         trigger: '.container',
//         start: '50%',
//         end: '100%',
//         scrub: true
//     }
// });

// gsap.to('#bottom', {
//     visibility: 'visible',
//     duration: 0.01,
//     scrollTrigger: {
        // trigger: '.container',
        // start: '90%',
        // end: '100%',
        // scrub: true
//     }
// });

// gsap.to('#center', {
//     visibility: 'visible',
//     duration: 1,
//     scrollTrigger: {
//         trigger: '.container',
//         start: '100%',
//         end: '200%',
//         scrub: true
//     }
// });

gsap.to('#bottom',{
    visibility:'hidden',
    duration: 0.01,
    scrollTrigger:{
        trigger: '#main',
        start: '10%',
        end: '100%',
        scrub: true
    }
});

gsap.to('.left-wall',{
    visibility:'hidden',
    duration: 0.01,
    scrollTrigger:{
        trigger: '#main',
        start: '-10%',
        end: '100%',
        scrub: true
    }
});

gsap.to('.right-wall',{
    visibility:'hidden',
    duration: 0.01,
    scrollTrigger:{
        trigger: '#main',
        start: '-10%',
        end: '100%',
        scrub: true
    }
});

gsap.to('.title-fixed',{
    visibility:'hidden',
    duration: 0.01,
    scrollTrigger:{
        trigger: '#main',
        start: '-10%',
        end: '100%',
        scrub: true
    }
});