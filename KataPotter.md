# KataPotter
![difficulty](https://img.shields.io/badge/Dificultad-Facil-green.svg)

Una kata de algoritmia facil para comenzar con el TDD

## Decripción del problema
Había una vez una serie de 7 libros sobre un héroe inglés llamado Harry. Niños de todo el mundo pensaron que eran fantástico y, por supuesto, también lo penso el editor. Entonces, en un gesto de inmensa generosidad hacia la humanidad (y para aumentar las ventas), establecio el siguiente modelo de precios para aprovechar los poderes mágicos de Harry.

Una copia de cualquiera de los siete libros cuesta 8 euros. Sin embargo, si compra dos libros diferentes de la serie, obtendrá un descuento del 5% en esos dos libros. Si compras 3 libros diferentes, obtienes un 10% de descuento. Con 4 libros diferentes, obtienes un 20% de descuento, con 5 un 25%, con 6 un 30%. Y si vas a por todas, y compras los 7, obtienes un gran descuento del 35%.

Ten en cuenta que si compras, por ejemplo, cuatro libros, de los cuales 3 son títulos diferentes, obtendrás un 10% de descuento en los 3 que forman parte de un conjunto, pero el cuarto libro aún cuesta 8 euros.

La manía de Potter está barriendo el país y los padres de adolescentes en todas partes hacen cola con cestas de compras rebosantes de libros de Potter. Su misión es escribir una pieza de código para calcular el precio de cualquier canasta de compras concebible, dando un descuento tan grande como sea posible.

## Libros
![Book covers](http://www.hogwartsla.com/news/uploads/covers_all.jpg)

## Cómo empezar
1. Clonamos el repo y creamos una rama nueva.
2. Abrimos el proyecto y dentro podremos ver una clase que pueda contener la informacion necesaria para el problema, la carcasa de la clase encargada de calcular el precio total y su test con el caso de prueba mas sencillo. 
3. Debemos empeza con hacer pasar el test que ya existe, y luego con *[TDD]* desarrollar el algoritmo para resolver el problema.

## Casos de prueba sugeridos
### Básicos
- [] => 0
- [1] => 8
- [2] => 8
- [3] => 8
- [4] => 8
- [5] => 8
- [6] => 8
- [7] => 8
- [1,1] => 8 * 2
- [2,2,2] => 8 * 3

### Descuento simple
- [1, 2] => 8 * 2 * 0.95
- [1, 2, 3] => 8 * 3 * 0.9
- [1, 2, 3, 4] => 8 * 4 * 0.8
- [1, 2, 3, 4, 5] => 8 * 5 * 0.75
- [1, 2, 3, 4, 5, 6] => 8 * 6 * 0.70
- [1, 2, 3, 4, 5, 6, 7] => 8 * 7 * 0.65

### Varios descuentos
- [1, 1, 2] => 8 + (8 * 2 * 0.95)
- [1, 1, 2, 2] => 2 * (8 * 2 * 0.95)
- [1, 1, 2, 3, 3, 4] => (8 * 4 * 0.8) + (8 * 2 * 0.95)
- [1, 2, 2, 3, 4, 5] => 8 + (8 * 5 * 0.75)

### Casos extremos
- [1, 1, 2, 2, 3, 3, 4, 5] => 2 * (8 * 4 * 0.8)
- [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5] => 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)
