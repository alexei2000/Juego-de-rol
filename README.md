# Bienvenidos a este juego de rol programado en **Java**

### Hecho por **Alexei Hernandez**.
---

## De que trata?

Este juego consiste en el modelado dos tipos de personajes `Wizard` y `Cleric` los cuales herendan de la clase `Character`  . Estos personajes tienen habilidades especiales, el `Wizard` tiene la habilidad aprender hechizos y de lanzarlos a sus aponentes. El `Cleric` puede rezarle a un diós y curar vida.

---

## Documentación

### Clases

* `Character`
* `Wizard`
* `Cleric`

---

### Clase `Character`

Esta clase es la clase padre de `Wizard` y `Cleric` en ella estan los atributos y métodos mas importantes que se caracteriza por ser común entre los dos tipos de personajes.

```java 
public abstract class Character
```

#### Atributos

```java
protected String name; //nombre
protected String type; //raza
protected int damage;  //daño
protected int intelligence; //inteligencia
protected int healthPointsMax; //vida máxima
protected int healthPoints; //vida actual
```

#### Métodos constructores

```java
public Character()
```

Este método constructor sin parametros se encarga de inicializar todos los atributos de forma aleatoria dentro de los límites permitidos.

```java
public Character(String name, String type, int damage, int intelligence, int hpm)
```

Este método constructor se encarga de inicializar todos los atributos especificados por el usuario.

#### Métodos setter

```java
public void setType()
```

Este método inicializa la raza del personaje de forma aleatoria teniendo como valores posibles: **Human, Dwarf, Ogre, Elf**

```java
public void setType(String tp)
```

Recibe como argumento la raza del personaje, si la raza no corresponde a uno de los valores posibles
se seleciona uno de manera aleatoria.

```java
public void setName()
```

Inicializa el nombre del personaje con el formato de **raza + codigo numerico unico basado en el tiempo**, esto hace que el nombre del personaje sea unico en el juego.

```java
public void setName(String nm)
```

Pide como argumento el nombre del personaje y lo inicializa.

```java
public void setHealthPointsMax()
```
Incializa la vida máxima del personaje de forma aleatoria dentro de los limites permitidos **Entre 0 y 100**, a parte inicializa la vida actual del personaje igual a la maxima.

```java
public void setHealthPointsMax(int hpmax)
```

Recibe un argumento la vida máxima validando los límites permitidos, si es mayor que el valor permitido le asigna el máximo permitido, en el caso de que sea menor que el valor menor permitido, le asigna el valor menor permitido.

```java
public void setHealthPoints()
```
Le asigna a la vida actual el valor de vida máximo.

```java
public void setHealthPoints(int hp)
```

Recibe como argumento la vida máxima, valida la entrada con respecto a los límites **de 0 a vida máxima**, si es mayor que la vida máxima, le asigna la vida maxima, si es menor que el limite inferior **(0)**, le asigna el límite inferior.

#### Metodos getter

```java
public String getName() //Retorna el nombre
```

```java
public String getType() //retorna la raza
```

```java
public int getDamage() //retorna el daño
```

```java
public int getIntelligence() //Retorna la inteligencia
```

```java
public int getHealthPointsMax() //Retorna la vida máxima
```

```java
public int getHealthPoints() //Retorna la vida
```

---

### Clase `Wizard`

Esta clase hereda de la clase `Chracter` y tiene algunos métodos y atributos adicionales, como tambien la implementación de los metodos `abstract` de `setDamage` y `setIntelligence` de la clase `Character`.

```java
public class Wizard extends Character
```

#### Atributos

```java
private static final ImageIcon sprite
```

En este atributo se guardará la textura del personaje mago, se ha hecho `static` con el proposito de que todos los magos tengan la misma textura

```java
private String[] spells;
```

En este atributo se guardarán los hechizos que puede realizar y ha aprendido el mago.

#### Metodos Constructores

```java
public Wizard()
```

Este método llama al constructor padre sin parametros y reserva memoria para el array `spells`.

```java
public Wizard(String name, String type, int damage, int intelligence, int hpm)
```

Este método llama al constructor padre con parámetros y reserva memoria para el array `spells`.

#### Métodos setter

Los siguientes métodos setter son en realidad una implementación de los métodos declarados en la clase `Character`.

```java
public void setDamage()
```

Establece el Daño dentro de los límites permitidos para el `Wizard` del **0 al 15**, de forma aleatoria.

```java
public void setDamage(int dm)
```

Establece el Daño dentro de los límites permitidos para el `Wizard` del **0 al 15**, si el argumento sobrepasa este límite se le asigna 15.

```java
public void setIntelligence()
```

Establece la inteligencia dentro de los límites permitidos para el `Wizard` del **17 al 20**, de forma aleatoria.

```java
public void setIntelligence(int itg)
```

Establece la inteligencia que es pasada como argumento y la valida con respecto a los límites permitidos para el `Wizard` del **17 al 20**, si es menor que 17 le asigna 17 y si es mayor que 20 le asigna 20.

#### Otros métodos de la clase

```java
public void printCharacterData()
```
Este método es propio de la clase padre `Character`, dicho método es `abstract` y la implementación se hace en esta clase.  
Este método muestra mediante una ventana todos los atributos del personaje como también su sprite.

```java
public void learnSpell(String spell)
```
Este método recibe como argumento un `String` el cual es el hechizo que va a prender el `Wizard` este se agrega al final de la lista de hechizos.

```java
public void spellSplash(Character ch)
```
Este método lanza un hechizo a un objeto tipo `Character` este le quita 10 de vida y hace que el `Wizard` olvide el ultimo hechizo que aprendió.

---

### Clase `Cleric`

Esta clase hereda de la clase `Character`.

```java
public class Cleric extends Character
```

#### Atributos

```java
private static final ImageIcon sprite
```
Este atributo se encarga de guardar la textura del personaje `Cleric`.

```java
private String god;
```
Este atributo guarda el nombre del diós a el cual el `Cleric` le reza.

#### Métodos constructores
```java
public Cleric()
```
Este método llama al constructor padre sin parametros e inicializa al dios del `Cleric` por defecto como **Dorime**.

```java
 public Cleric(String name, String type, int damage, int intelligence, int hpm, String god)
```

Este método llama al constructor padre con parámetros y como adicional asigna el noambre al dios que es pasado en los argumentos.

#### Métodos setter

De la misma manera como la clase `Wizard` estos metodos son la implementación de los métodos de la clase padre `Character`.

```java
public void setDamage()
```

Establece el Daño dentro de los límites permitidos para el `Cleric` del **18 al 20**, de forma aleatoria.

```java
public void setDamage(int dm)
```

Establece el Daño dentro de los límites permitidos para el `Cleric` del **18 al 20**, si el argumento sobrepasa este límite se le asigna 20, si se antepone, le asigna 18.

```java
public void setIntelligence()
```

Establece la inteligencia dentro de los límites permitidos para el `Cleric` del **12 al 16**, de forma aleatoria.

```java
public void setIntelligence(int itg)
```

Establece la inteligencia que es pasada como argumento y la valida con respecto a los límites permitidos para el `Cleric` del **12 al 16**, si es menor que 12 le asigna 12 y si es mayor que 16 le asigna 16.

```java
 public void setGod()
 ```
 Este método es propio de la clase `Cleric`.
 este metodo no recibe argumento y asigna por defecto el nombre de **Dorime** al dios del `Cleric`.

 ```java
public void setGod(String god)
 ```

 Este método a diferencia del anterior pide como argumento una variable tipo `String` el cual es el nombre del diós a el cual el `Cleric` le reza para tener sus poderes.

 #### Métodos getter

 ```java
 public String getGod()
 ```
 Retorna el nombre del diós.

 #### Otros Metodos

 ```java
public void printCharacterData()
 ```
Este método es la implementacion del método de la clase `Character`, el cual imprime todos los datos del `Cleric` y su sprite en una ventana.

```java
public void heal(Character ch)
```

Este método es unico de la clase `Cleric`, el cual recibe como argumento un objeto tipo `Character` y le cura 10 de vida. al curarlo no excede su valor de vida máxima.




















