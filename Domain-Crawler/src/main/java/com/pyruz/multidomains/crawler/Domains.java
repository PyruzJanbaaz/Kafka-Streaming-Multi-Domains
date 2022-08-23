package com.pyruz.multidomains.crawler;

import java.util.List;
import java.util.Objects;

public class Domains {
    private List<Domain> domains;

    public Domains(List<Domain> domains) {
        this.domains = domains;
    }

    public Domains() {
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return "Domains{" +
                "domains=" + domains +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domains domains1 = (Domains) o;
        return Objects.equals(domains, domains1.domains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domains);
    }
}
