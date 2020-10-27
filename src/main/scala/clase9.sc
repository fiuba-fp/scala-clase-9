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

// 1: Implementar la instancia de Monoid para la suma de Exprs

// 2. Implementar instancia de Monoid para la multiplicacion de Exprs

// 3. Implementar la instancia de Functor para los arboles binarios
sealed trait BinaryTree[+A]
case class Leaf[A](value: A) extends BinaryTree[A]
case class Branch[A](left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]
