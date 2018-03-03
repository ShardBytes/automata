/* p5.js Bubbles by Plasmoxy */
var infoDiv = document.getElementById("info");

var bubbles = [];
var pxPerSec = 1/60.0;
var speed = 200 * pxPerSec;

var LOADED = false;

var textPadding = 10;

var tscale;

function bubble(stx,sty) {
   this.x = stx;
   this.y = sty;
   this.r = 100;
   this.color = [0, 0, 255];
   this.draw = function() {
      fill(this.color[0], this.color[1], this.color[2]);
      ellipse(this.x, this.y, this.r, this.r);
   }
}

function addBubble(x, y) {
   var a = new bubble(x, y);
   a.color = [Math.random()*255,  Math.random()*255, Math.random()*255];
   bubbles.push(a);
}

function move() {
  bubbles.forEach(function(a,i) {
    a.y += speed;
  });
}

function setup() {
  if (LOADED) {
    createCanvas(windowWidth-15, windowHeight-20);
    tscale = windowWidth/80;
    setInterval(move, 1000/60);
  }
}

function draw() {

   var textpos = 30;
   let textdiff = 10;
   clear();

   fill("#E91E63");
   textpos += 3*tscale + textdiff;
   textSize(3*tscale);
   text("Bubbles by Plasmoxy <p5.js> using WebView", textPadding, textpos);

   textpos += 3*tscale + textdiff;
   textSize(3*tscale);
   fill("#FFEB3B");
   text("Bubbles: "+ (bubbles.length), textPadding, textpos);

   textpos += 3*tscale + textdiff;
   textSize(3*tscale);
   fill("white");
   if (bubbles[0]) text("Last bubble : ["+parseInt(bubbles[bubbles.length-1].x)+",  "+parseInt(bubbles[bubbles.length-1].y) + "]", textPadding, textpos);

   bubbles.forEach(function(a,i) {
     if (a.y > windowHeight || isNaN(a.y)) {
       bubbles.splice(bubbles.indexOf(a), 1);
     }
     a.draw();
   });
}

window.addEventListener('load', function(){

    document.body.addEventListener('touchstart', function(e){
        var t = e.changedTouches;
        for(i=0; i<t.length; i++) {
          addBubble(t[i].pageX, t[i].pageY);
        }
    }, false)

    LOADED = true;
    setup();

}, false);
