Learn Jetpack Compose
=====================

> Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.

Terminology
-----------

* Composable / Composable Function:

    Normal Kotlin functions with the `@Composable` annotation accept parameters but do not return anything instead of emitting UI components.

    ```kotlin
    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name!")
    }
    ```

* Modifier:

    In Compose, we use `Modifier` to decorate composables, they can change the composable's size, layout, appearance or add high-level interactions, such as making an element clickable.

    ```kotlin
    @Composable
    fun MessageCard(name: String) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }
    ```

Useful Composables
------------------

* `Text`
* `Image`
* `Column`, `Row`
* `Surface`
* `Spacer`
* `LazyColumn`, `LazyRow`

Useful Modifier
---------------

* `size`
* `clip`
* `border`
* `clickable`
* `animateContentSize`
