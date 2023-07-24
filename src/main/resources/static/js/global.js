(function ($) {
    $("#reset-qr").click(function(){
        window.location.href = "/";
    });

    $("#share-qr").click(function(){
        let imgUrl = $('#qr-image').prop('src')
            console.log(imgUrl);
          navigator.clipboard.writeText(imgUrl);
          $("#share-qr").html('Copied!');
    });
})(jQuery);