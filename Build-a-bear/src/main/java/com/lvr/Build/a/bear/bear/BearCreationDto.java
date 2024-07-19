package com.lvr.Build.a.bear.bear;

public record BearCreationDto(String name, String type) {
  public Bear toBear() {
    Bear bear = new Bear();
    if (this.name != null) bear.setName(this.name);
    return bear;
  }
}
