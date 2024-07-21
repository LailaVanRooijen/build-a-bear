import { UUID } from "crypto";

export interface IBear {
  id: UUID;
  color: string;
  name: string;
  outfit: string;
  head: string;
  chest: string;
  feet: string;
}
