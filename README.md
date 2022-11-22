# Pokemonos

Una vez iniciado el juego pantalla de carga
3 opciones: Reglas Jugar Salir
Reglas: Salta ventana con pequeña explicación del juego y reglas 
Jugar: 2 opciones, si no se indica usuario; ventana emergente con aviso por falta de usuario
Si hay usuario, avanza con el juego como tal.
Salir: finaliza el programa y se cierran las ventanas

Dentro del juego, apareces dentro del primer combate tras haberse cargado los pokemon, movimientos tanto propios como rivales.
En la pantalla aparecen imagenes del pokemon propio y del rival, cada uno con sus respectivas barras de vida y tipos.
El usuario dispone de 4 movimientos que pueden variar entre movimientos de ataque, que simplemente afectan en el rival, o movimientos especiales, que pueden afectar sobre las estadisticas propias o del rival.
Cada movimiento indica o el tipo, o la influencia que tiene.
Cada ronda permite un ataque propio y uno rival, siendo el objetivo derrotar al pokemon rival, haciendolo sucesivamente hasta ganar o perder el combate dependiendo de quien se quede sin pokemon primero.

La maquina compara tanto estadisticas propias como rivales para decidir quien ataca primero (estadistica de velocidad) y cuanto daño hacen los ataques (utiliza una formula en la que entran en juego tanto las estadisticas de ataque y defensa, como los tipos de ambos pokemon que influyen en la eficacia)
Todos los elementos anteriormente mecionados son visibles en la terminal del programa y desde los movimientos utilizados como las eficacias por tipos

Al finalizar el juego, salta una ventana con un mensaje dependiendo de si se gana o se pierde
