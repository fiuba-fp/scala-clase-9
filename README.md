# Algoritmos 4 - Clase 9

## Ejercicios

1. Completar la instancia de Monoid para la suma de Exprs
```scala
implicit val exprMonoid: Monoid[Expr] = new Monoid[Expr] {
  // elemento neutro 
  def empty: Expr = ???

  // operacion binaria
  def combine(e1: Expr, e2: Expr): Expr = ???
}
```
2. Implementar la instancia de Monoid para la multiplicacion de Exprs

3. Completar la instancia de Functor para el tipo Option[A]
```scala
sealed trait Option[+A]
case object None extends Option[Nothing]
case class Some[A](value: A) extends Option[A]
```

4. Implementar la instancia de Functor para los arboles binarios
```scala
sealed trait BinaryTree[+A]
case class Leaf[A](value: A) extends BinaryTree[A]
case class Branch[A](left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]
```