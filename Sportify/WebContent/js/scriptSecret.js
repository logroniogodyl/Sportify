var ball    = document.querySelector('.ball'),
    y       = 1,
    gravity = 1;



setInterval(function(){

  if(y>600){ 
	gravity = -gravity; 
	}
  
  gravity+=1;
  y = y + gravity;
  ball.style.top = y + "px";
},50);

