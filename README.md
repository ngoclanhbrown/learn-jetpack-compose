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

* State:

    To add internal state to a composable, you can use the `mutableStateOf` function, which makes Compose recompose functions that read that `State`. To preserve state across recompositions, remember the mutable state using `remember`.

    The composable function will automatically be "subscribed" to the state. If the state changes, composables that read these fields will be recomposed to display the updates.

* State Hoisting:

    In Composable functions, state that is read or modified by multiple functions should live in a common ancestor—this process is called **state hoisting**. To *hoist* means to *lift* or *elevate*.

    Making state hoistable avoids duplicating state and introducing bugs, helps reuse composables, and makes composables substantially easier to test. Contrarily, state that doesn't need to be controlled by a composable's parent should not be hoisted. The **source of truth** belongs to whoever creates and controls that state.

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
* `wrapContentWidth`, `wrapContentHeight`, `wrapContentSize`
