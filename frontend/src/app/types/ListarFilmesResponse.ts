import { Filme } from "./Filme"

export type ListarFilmesResponse = {
    message:string,
    filmes: Filme[]
}