import { UUID } from "crypto";

export interface IColor {
  id: UUID;
  color: string;
}

export interface IVoice {
  id: UUID;
  voice: string;
}

export interface IFurType {
  id: UUID;
  furType: string;
}

export interface IFurPattern {
  id: UUID;
  furPattern: string;
}

export interface IOutfit {
  id: UUID;
  name: string;
  head: string;
  chest: string;
  feet: string;
}

export interface IHead {
  id: UUID;
  head: string;
}

export interface IChest {
  id: UUID;
  chest: string;
}

export interface IFeet {
  id: UUID;
  feet: string;
}
