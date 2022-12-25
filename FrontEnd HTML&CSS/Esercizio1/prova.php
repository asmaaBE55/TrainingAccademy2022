<?php
$nome = "Asmaa";
echo "Il mio nome è " . $nome;
function stampa_nome($nome) {
    echo "<strong>Ciao " . $nome . "</strong>";
}
stampa_nome($nome);
?>