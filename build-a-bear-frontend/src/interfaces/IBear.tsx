import { UUID } from "crypto";

export interface IBear {
  id: UUID;
  furType: string;
  furPattern: string;
  voice: string;
  color: string;
  name: string;
  outfit: string;
  head: string;
  chest: string;
  feet: string;
}
