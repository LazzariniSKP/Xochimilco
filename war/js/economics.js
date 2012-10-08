    var puntos = [];
    var  ventanas= [];
        var unpunto = null;
        var map = null;
        var center = null;
 
        $.getJSON("/economicsservlet?opcion=1", {}, function(data){
                        $.each(data.places, function(i, item){
                                        center  = new google.maps.LatLng(item.lat, item.lon);                          
                        });
                });
               
               
        function initialize() {      
                        var mapOptions = {
                             center: center,
                                 zoom: 12,
                             mapTypeId: google.maps.MapTypeId.ROADMAP,
                             mapTypeControl: true,
                             disableDoubleClickZoom: true,
                             minZoom:10,
                             maxZoom:18,                    
                                                mapTypeControlOptions: {
                                                        style: google.maps.MapTypeControlStyle.DROPDOWN_MENU
                                                },
                                                navigationControl: true,
                                                navigationControlOptions: {
                                                style: google.maps.NavigationControlStyle.SMALL
                                                }
                };
         map = new google.maps.Map(document.getElementById("mapa"),
            mapOptions);
    }
 
     
 
       
 
    function hide(){
                if(puntos){
                        for(p in puntos){
                                puntos[p].setMap(null);
                        }
                }
    }
 
 
 
  function economics(){
                 var chinampa = 'imgs/chinampa.jpg';
                 var flor = 'imgs/flor.jpg';

 
        $.getJSON("/economicsservlet?opcion=2", {}, function(data){
                        $.each(data.places, function(i, item){
                       
                                var marker = new google.maps.Marker({
                                        position: new google.maps.LatLng(item.latitud,
                                         item.altitud),
                                        map: map,
                                        title: item.title,
                                        icon:chinampa
                                });
                                puntos[i] = marker;
                                var infowindow = new google.maps.InfoWindow({
                                        content: "<h3>"+ item.nombre +"</h3><p>"+
                                        item.nombre +"</p>" + '<div>'+
                                     '<img src="' + item.imagen + '" />'+'</div>'+ '<div>'+ 
                                     '<video width="320" height="240" controls="controls">'+
                                       '<source src="' +item.video + '" type="video/mp4"/>'+
                                     '</video>'
                                   +'</div>'
                                });
                                ventanas[i] = infowindow;
                                google.maps.event.addListener(marker, 'click', function() {
                                        infowindow.open(map, marker);
                                });
                        });
                });
         }
 
    function showEconomics(){
        hide();
        economics();
    }