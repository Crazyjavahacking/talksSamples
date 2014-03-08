(* Pattern matching & SML *)
fun append (xs, ys) =
  case xs of
      []     => ys
    | x::xs' => x :: append (xs', ys)

(* Pattern matching & SML *)
fun map (f, xs) =
  case xs of
      []     => []
    | x::xs' => (f x) :: map(f, xs')
