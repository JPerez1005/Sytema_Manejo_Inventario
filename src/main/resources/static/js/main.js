let d=document;

//toggle reset button
function toggleResetBtn() {
    const resetBtn = d.querySelector('.reset');
    resetBtn.classList.toggle('active');
}

// Switch left, middle and right part of banner
function switchBanner(name){
    const banner=d.querySelector('#banner');
    if(!banner.classList.contains(name)){
        banner.className='banner';
        banner.classList.add(name);
        //whenever the switch the banner, the button should toggle
        toggleResetBtn();
    }
    return;
}

//Reset button
function resetBanner() {
    const banner=d.querySelector('#banner');
    banner.className='banner';
}

