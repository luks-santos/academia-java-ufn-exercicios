$(function() {
    var usuario = localStorage.getItem("usuario");
            
    if (usuario === 'admin') {
        exibirUsuarioLogado(usuario);
    }
    
    $("#form-login").submit(function(event) {
        event.preventDefault();
        
        var usuario = $("#usuario").val();
        var senha = $("#senha").val();

        if (usuario === 'admin' && senha === 'admin') {
            localStorage.setItem("usuario", usuario);
            exibirUsuarioLogado(usuario);
        }
    });

    // Delegação de evento para o link "Sair do Sistema"
    $(document).on("click", "#sair", function(event) {
        event.preventDefault();
        localStorage.clear();
        location.reload();
    });

    function exibirUsuarioLogado(usuario) {
        $("#form-login").html(`<p>Usuário logado: ${usuario}</p><br>
        <a href="." id="sair" style="color: white; text-decoration: underline;">Sair do Sistema</a>`);
    }
});
