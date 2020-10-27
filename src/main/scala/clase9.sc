import cats._

sealed trait Expr
case class Literal(value: Int) extends Expr
case class Add(lhs: Expr, rhs: Expr) extends Expr
case class Mult(lhs: Expr, rhs: Expr) extends Expr

object Expr {
  def eval(expr: Expr): Int = expr match {
    case Literal(v) => v
    case Add(lhs, rhs) => eval(lhs) + eval(rhs)
    case Mult(lhs, rhs) => eval(lhs) * eval(rhs)
  }
}

val expr = Add(Literal(3), Mult(Literal(2), Literal(4)))

// 1. Completar la instancia de Monoid para la suma de Exprs
implicit val exprMonoid: Monoid[Expr] = new Monoid[Expr] {
  // elemento neutro
  def empty: Expr = ???

  // operacion binaria
  def combine(e1: Expr, e2: Expr): Expr = ???
}

// 2. Implementar instancia de Monoid para la multiplicacion de Exprs

// 2b. Que sucede si intento utilizar ambas instancias al mismo tiempo?

// 3. Completar la instancia de Functor para el tipo Option[A]
sealed trait Option[+A]
case object None extends Option[Nothing]
case class Some[A](value: A) extends Option[A]

implicit val optionFunctor: Functor[Option] = new Functor[Option] {
  def map[A, B](opt: Option[A])(f: A => B): Option[B] = ???
}


// 4. Implementar la instancia de Functor para los arboles binarios
sealed trait BinaryTree[+A]
case class Leaf[A](value: A) extends BinaryTree[A]
case class Branch[A](left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]