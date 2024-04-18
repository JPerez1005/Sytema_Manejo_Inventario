const wrapper_add=document.querySelector('.wrapper-add'),
addLink=document.querySelector('.modify-link'),
modifyLink=document.querySelector('.add-link'),
btn_open=document.querySelector('.add-model'),
iconClose_2=document.querySelector('.icon-close2');


modifyLink.addEventListener('click', ()=> {
    wrapper_add.classList.add('active');
});
addLink.addEventListener('click', ()=> {
    wrapper_add.classList.remove('active');
});
btn_open.addEventListener('click', ()=> {
    wrapper_add.classList.add('active-popup');
});
iconClose_2.addEventListener('click', ()=>{
    wrapper_add.classList.remove('active-popup');
});