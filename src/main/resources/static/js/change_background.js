
let toggleBtn=document.querySelector('.theme-toggle');
const allElements = document.querySelectorAll('*');

toggleBtn.addEventListener('click', ()=>{
    document.body.classList.toggle('dark');

    allElements.forEach((el)=>{
        el.classList.add('transition');
        setTimeout(()=>{
            el.classList.remove('transition');
        }, 1000);
    });
});